package com.example.ieharrison_spring.ieharrison;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // publica los endpoints (urls con peticiones)
@RequestMapping("/ieharrison")
@RequiredArgsConstructor
public class IeharrisonController {

  @Autowired
  private final IeharrisonService ieharrisonService;

  @PostMapping("/createIeharrison")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison created successfully"),
      @ApiResponse(responseCode = "205", description = "WARNING: Ieharrison partially created (fields missing)"),
  })
  public ResponseEntity<String> createIeharrison(
      @RequestBody Ieharrison ieharrison) {
    if (ieharrison.getName() == null ||
        ieharrison.getSurname() == null ||
        ieharrison.getBalance() == null ||
        ieharrison.getEmail() == null) {
      System.out.println("Missing fields detected: " + ieharrison);
      return ResponseEntity
          .status(HttpStatus.PARTIAL_CONTENT)
          .body("ERROR: Ieharrison partially created (fields missing)");
    } else {
      ieharrisonService.createIeharrison(ieharrison);
      return ResponseEntity.ok("Ieharrison created successfully");
    }
  }

  @PutMapping("removeIeharrison/{id}")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison removed succesfully"),
      @ApiResponse(responseCode = "209", description = "ERROR: ieharrison not removed"),
  })
  public ResponseEntity<String> removeIeharrison(@PathVariable String id) {
    if (ieharrisonService.removeIeharrison(Integer.parseInt(id))) {
      return ResponseEntity.ok("Se ha borrado la ieharrison correctamente");
    } else {
      return ResponseEntity
          .status(201)
          .body("ERROR: no se ha realizado el registro, no estaba en la DB");
    }
  }

  @GetMapping("findIeharrison/{id}")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison found succesfully"),
      @ApiResponse(responseCode = "209", description = "ERROR: ieharrison not found"),
  })
  public ResponseEntity<Optional<Ieharrison>> findIeharrison(
      @PathVariable String id) {
    return ResponseEntity.ok(
        ieharrisonService.findIeharrison(Integer.parseInt(id)));
  }

  // todos
  @GetMapping("findAll")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison elements found succesfully"),
      @ApiResponse(responseCode = "209", description = "ERROR: no elements at ieharrison"),
  })
  public ResponseEntity<List<Ieharrison>> findAll() {
    return ResponseEntity.ok(ieharrisonService.findAll());
  }

  // EDIT
  @PostMapping("editIeharrison/{id}") // http://localhost:8080/ieharrison/editIeharrison
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison edited succesfully"),
      @ApiResponse(responseCode = "201", description = "ERROR: ieharrison partially edited"),
      @ApiResponse(responseCode = "209", description = "ERROR: ieharrison not found"),
  })
  public ResponseEntity<Optional<Ieharrison>> editIeharrison(
      @PathVariable String id,
      @RequestBody Ieharrison ieharrison) {
    ieharrisonService.editIeharrison(Integer.parseInt(id), ieharrison);

    return ResponseEntity.ok(
        ieharrisonService.editIeharrison(Integer.parseInt(id), ieharrison));
  }

  // REMOVE ALL
  @DeleteMapping("/removeAll") // http://localhost:8080/ieharrison/removeAll
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "All Ieharrisons removed successfully"),
      @ApiResponse(responseCode = "204", description = "ERROR: No Ieharrisons to remove"),
  })
  public ResponseEntity<String> removeAll() {
    if (ieharrisonService.removeAll()) {
      return ResponseEntity.ok("All Ieharrisons removed successfully");
    } else {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("ERROR: No Ieharrisons to remove");
    }
  }

  // INCREASE BALANCE
  @PutMapping("/increaseBalance/{id}")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Balance increased successfully"),
      @ApiResponse(responseCode = "201", description = "Balance initialized and increased successfully"),
      @ApiResponse(responseCode = "209", description = "ID does not exist"),
  })
  public ResponseEntity<String> increaseBalance(
      @PathVariable String id,
      @RequestParam Float cantidad) {
    Integer result = ieharrisonService.increaseBalance(
        Integer.parseInt(id),
        cantidad);

    if (result != null) {
      if (result == 200) {
        return ResponseEntity.ok("Balance increased successfully");
      } else if (result == 201) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Balance initialized and increased successfully");
      } else {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("ID does not exist");
      }
    } else {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("ID does not exist");
    }
  }

  // DECREASE BALANCE
  @PutMapping("/decreaseBalance/{id}")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Balance reduced successfully and positive"),
      @ApiResponse(responseCode = "201", description = "Balance reduced and negative"),
      @ApiResponse(responseCode = "209", description = "ID does not exist"),
  })
  public ResponseEntity<String> decreaseBalance(
      @PathVariable String id,
      @RequestParam Float cantidad) {
    Integer result = ieharrisonService.decreaseBalance(
        Integer.parseInt(id),
        cantidad);

    if (result != null) {
      if (result == 0) {
        return ResponseEntity.ok("Balance reduced successfully and positive");
      } else {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Balance reduced and negative");
      }
    } else {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("ID does not exist");
    }
  }

  @GetMapping("/average")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Average balance succesfully found"),
      @ApiResponse(responseCode = "201", description = "Average balance is negative"),
      @ApiResponse(responseCode = "209", description = "No ieharrisons found"),
  })
  public ResponseEntity<String> average() {
    Float average = ieharrisonService.calculateAverageBalance();

    if (average != null) {
      if (average >= 0) {
        return ResponseEntity.ok("Average balance of all records");
      } else {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("The average balance is negative");
      }
    } else {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No ieharrisons found");
    }
  }
}

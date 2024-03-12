package com.example.ieharrison_spring.ieharrison;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

import org.hibernate.internal.util.type.PrimitiveWrapperHelper.IntegerDescriptor;
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
  public ResponseEntity<?> createIeharrison(
      @RequestBody Ieharrison ieharrison) {
    if (ieharrison.getName() == null ||
        ieharrison.getSurname() == null ||
        ieharrison.getBalance() == null ||
        ieharrison.getEmail() == null) {
      ieharrisonService.createIeharrison(ieharrison);
      return ResponseEntity
          .status(205)
          .body("WARNING: Ieharrison partially created (fields missing)"); // 205 NO DEJA IMPRIMIR COSAS
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
      return ResponseEntity.ok("IEHarrison removed succesfully");
    } else {
      return ResponseEntity
          .status(209)
          .body("ERROR: IEHarrison not removed, couldnt be found on DB");
    }
  }

  @GetMapping("findIeharrison/{id}")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison found succesfully"),
      @ApiResponse(responseCode = "209", description = "ERROR: ieharrison not found"),
  })
  public ResponseEntity<?> findIeharrison(
      @PathVariable String id) {
    Optional<Ieharrison> ieharrison = ieharrisonService.findIeharrison(Integer.parseInt(id)); // por sino lo encuentra

    if (ieharrison.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(ieharrison);
    } else {
      System.out.println("ERROR: ieharrison not found");
      return ResponseEntity.status(209).body("No IEHarrison with that ID on the DB");
    }

  }

  // todos
  @GetMapping("findAll")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison elements found succesfully"),
      @ApiResponse(responseCode = "209", description = "ERROR: no elements at ieharrison"),
  })
  public ResponseEntity<?> findAll() {
    if (ieharrisonService.findAll().isEmpty()) {
      return ResponseEntity.status(209).body("No IEHarrisons on the DB");
    } else {
      return ResponseEntity.ok(ieharrisonService.findAll());
    }
  }

  // EDIT
  @PostMapping("editIeharrison/{id}") // Endpoint: http://localhost:8080/ieharrison/editIeharrison
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Ieharrison edited successfully"),
      @ApiResponse(responseCode = "201", description = "Partial edit: ieharrison updated with errors"),
      @ApiResponse(responseCode = "209", description = "ERROR: ieharrison not found"),
  })
  public ResponseEntity<String> editIeharrison(
      @PathVariable String id,
      @RequestBody Ieharrison ieharrison) {
    ieharrisonService.editIeharrison(Integer.parseInt(id), ieharrison);

    Optional<Ieharrison> editedIeharrison = ieharrisonService.editIeharrison(Integer.parseInt(id), ieharrison);

    if (editedIeharrison.isPresent()) {
      if (ieharrison.getName() == null ||
          ieharrison.getSurname() == null ||
          ieharrison.getBalance() == null ||
          ieharrison.getEmail() == null) {
        return ResponseEntity.status(201).body("IEHarrison updated partially");
      } else {
        return ResponseEntity.ok("IEHarrison correctly updated");
      }
    } else {
      return ResponseEntity.status(209).body("Couldnt find that IEHarrison on the DB");
    }
  }

  // REMOVE ALL
  @DeleteMapping("/removeAll")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "All Ieharrisons removed successfully"),
      @ApiResponse(responseCode = "204", description = "ERROR: No Ieharrisons to remove"),
  })
  public ResponseEntity<String> removeAll() {
    if (ieharrisonService.findAll().isEmpty()) {
      System.out.println("ERROR: No Ieharrisons to remove (cant print it on TC response)");

      return ResponseEntity
          .status(204)
          .body("ERROR: No Ieharrisons to remove"); // no me lo imprime no sé por qué
    } else {
      ieharrisonService.removeAll();
      return ResponseEntity.ok("All Ieharrisons removed successfully");
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
      @PathVariable Integer id,
      @RequestBody Ieharrison ieharrison) { // LO HE HECHO CON @REQUESTBODY, NO ME SALÍA CON OTRO PATH
    Integer result = ieharrisonService.increaseBalance(
        id,
        ieharrison.getBalance());

    if (result != null) {
      if (result == 200) {
        return ResponseEntity.ok("Balance increased successfully");
      } else if (result == 201) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Balance initialized and increased successfully");
      } else {
        return ResponseEntity
            .status(209)
            .body("ID does not exist");
      }
    } else {
      return ResponseEntity
          .status(209)
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
      @RequestBody Ieharrison ieharrison) {
    Integer result = ieharrisonService.decreaseBalance(
        Integer.parseInt(id),
        ieharrison.getBalance());

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
        return ResponseEntity.ok("Average balance of all records : " + average);
      } else {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("The average balance is negative : " + average);
      }
    } else {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No ieharrisons found");
    }
  }
}

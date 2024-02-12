1. 
for $zona in distinct-values(//producto/zona)
   return 
      <zona numero="{$zona}">
         {count(//producto[zona = $zona])}
      </zona>

2. 
let $zona := 10
   return
      if ($zona = 10)
      then //producto/zona10/denominacion
      else if ($zona = 20)
      then //producto/zona20/denominacion
      else if ($zona = 30)
      then //producto/zona30/denominacion
      else //producto/zona40/denominacion

3. 
for $zona in distinct-values(//producto/zona)
   return 
      <zona numero="{$zona}">
         {let $maxPrecio := max(//producto[zona = $zona]/precio)
          return
             <producto_mas_caro>
                {//producto[zona = $zona and precio = $maxPrecio]/denominacion}
             </producto_mas_caro>}
      </zona>

4. 
<placa>{//producto[contains(denominacion, "Placa Base")]/denominacion}</placa>
   <memoria>{//producto[contains(denominacion, "Memoria")]/denominacion}</memoria>
   <micro>{//producto[contains(denominacion, "Micro")]/denominacion}</micro>
   <otros>{//producto[not(contains(denominacion, "Placa Base") or contains(denominacion, "Memoria") or contains(denominacion, "Micro"))]/denominacion}</otros>

5. 
   1. producto más barato de cada zona:
      ```xquery
      for $zona in distinct-values(//producto/zona)
      return 
         <zona numero="{$zona}">
            {let $minPrecio := min(//producto[zona = $zona]/precio)
             return
                <producto_mas_barato>
                   {//producto[zona = $zona and precio = $minPrecio]/denominacion}
                </producto_mas_barato>}
         </zona>
      ```

   2. promedio de precios por zona:
      ```xquery
      for $zona in distinct-values(//producto/zona)
      return 
         <zona numero="{$zona}">
            {avg(//producto[zona = $zona]/precio)}
         </zona>
      ```

   3. productos con un descuento del 20%:
      ```xquery
      for $producto in //producto
      where $producto/precio * 0.8 > $producto/precio_rebajado
      return $producto
      ```

   4. productos cuya denominación tiene más de 10 caracteres:
      ```xquery
      //producto[string-length(denominacion) > 10]
      ```

   5. productos con un precio superior a 100 euros y cuya denominación comienza con la letra 'A':
      ```xquery
      //producto[precio > 100 and starts-with(denominacion, "A")]
      ```

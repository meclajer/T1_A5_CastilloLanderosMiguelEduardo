import java.io._

object Principal {
  def main(args: Array[String]): Unit = {
    println("\n\n\tARCHIVOS CON SCALA\n\nEl archivo que se leera es: \"ArchivoParaLectura.java\"\n")

    var archivo = new File("ArchivoParaLectura.java")
    if(archivo.exists()) {
      if (archivo.canRead){


        println("Archivo listo para trabajar.-\n\t\tRESULTADOS")

        //1.- Cantidad de lineas de codigo.
        cantidadDeLineas(archivo)
        //2.- Cantidad de lineas en blanco.
        cantidadDeLineasEnBlanco(archivo)
        //3.- Paréntensis balanceados.
        parentesisBalanceados(archivo)
        //4.- LLaves balanceadas.
        llavesBalanceadas(archivo)
        //5.- Corchetes balanceados.
        corchetesBalanceados(archivo)

      }
    } else {
      println("Archivo no dosponible...")
    }

  }

  def cantidadDeLineas( archivo: File ): Unit = {

    //Apertura del fichero
    var fr = new FileReader(archivo)
    //Buffer de lectura
    var br = new BufferedReader(fr)

    //Lectura
    println("Cantidad de lineas del archivo: "+br.lines().count().toInt+".")

  }

  def cantidadDeLineasEnBlanco( archivo: File ): Unit = {

    //Apertura del fichero
    var fr = new FileReader(archivo)
    //Buffer de lectura
    var br = new BufferedReader(fr)

    //Variable de referencia para el conteo
    var ref: Int = 0;
    var catntidadLineasBlancas: Int = 0;;

    //Lectura
    var linea: String = br.readLine() // lee la primera linea
    if (linea != null){ // Si la primera linea no es == null la muestra
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido){
          if (caracter != " "){
            ref = ref + 1;
          }
        }

        //Si la referencia es igual a 0 la linea es blanca (limpia)
        if (ref == 0){
          catntidadLineasBlancas = catntidadLineasBlancas + 1;
        }
        // Reinicia el contador de referencias
        ref = 0;

        linea = br.readLine()
      } while ( linea != null)
    }

    println("Cantidad de lineas en blanco: "+catntidadLineasBlancas+".")

  }

  def parentesisBalanceados( archivo: File ): Unit = {

    //Apertura del fichero
    var fr = new FileReader(archivo)
    //Buffer de lectura
    var br = new BufferedReader(fr)

    //Variable de referencia para el conteo
    var parentesisAbiertos: Int = 0;;
    var parentesisCerrados: Int = 0;;

    //Lectura
    var linea: String = br.readLine() // lee la primera linea
    if (linea != null){ // Si la primera linea no es == null la muestra
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido){
          if (caracter == "("){ //Si encuentra un parentesis abierto suma 1
            parentesisAbiertos = parentesisAbiertos + 1;
          }
          if (caracter == ")"){ //Si encuentra un parentesis cerrado suma 1
            parentesisCerrados = parentesisCerrados + 1;
          }
        }

        linea = br.readLine()
      } while ( linea != null)
    }

    if ( parentesisAbiertos == parentesisCerrados){
      println("Paréntensis balanceados: Si.")
    } else {
      if (parentesisAbiertos > parentesisCerrados){
        println("Paréntensis balanceados: No, debe cerrar "+ (parentesisAbiertos - parentesisCerrados) +".")
      } else {
        println("Paréntensis balanceados: No, debe abrir "+ (parentesisCerrados - parentesisAbiertos) +".")
      }
    }

  }

  def llavesBalanceadas( archivo: File ): Unit = {

    //Apertura del fichero
    var fr = new FileReader(archivo)
    //Buffer de lectura
    var br = new BufferedReader(fr)

    //Variable de referencia para el conteo
    var llavesAbiertas: Int = 0;;
    var llavesCerradas: Int = 0;;

    //Lectura
    var linea: String = br.readLine() // lee la primera linea
    if (linea != null){ // Si la primera linea no es == null la muestra
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido){
          if (caracter == "{"){ //Si encuentra un parentesis abierto suma 1
            llavesAbiertas = llavesAbiertas + 1;
          }
          if (caracter == "}"){ //Si encuentra un parentesis cerrado suma 1
            llavesCerradas = llavesCerradas + 1;
          }
        }

        linea = br.readLine()
      } while ( linea != null)
    }

    if ( llavesAbiertas == llavesCerradas){
      println("Llaves balanceadas: Si.")
    } else {
      if (llavesAbiertas > llavesCerradas){
        println("Llaves balanceadas: No, debe cerrar "+ (llavesAbiertas - llavesCerradas) +".")
      } else {
        println("Llaves balanceadas: No, debe abrir "+ (llavesCerradas - llavesAbiertas) +".")
      }
    }

  }

  def corchetesBalanceados( archivo: File ): Unit = {

    //Apertura del fichero
    var fr = new FileReader(archivo)
    //Buffer de lectura
    var br = new BufferedReader(fr)

    //Variable de referencia para el conteo
    var corchetesAbiertos: Int = 0;;
    var corchetesCerrados: Int = 0;;

    //Lectura
    var linea: String = br.readLine() // lee la primera linea
    if (linea != null){ // Si la primera linea no es == null la muestra
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido){
          if (caracter == "("){ //Si encuentra un parentesis abierto suma 1
            corchetesAbiertos = corchetesAbiertos + 1;
          }
          if (caracter == ")"){ //Si encuentra un parentesis cerrado suma 1
            corchetesCerrados = corchetesCerrados + 1;
          }
        }

        linea = br.readLine()
      } while ( linea != null)
    }

    if ( corchetesAbiertos == corchetesCerrados){
      println("Corchetes balanceados: Si.")
    } else {
      if (corchetesAbiertos > corchetesCerrados){
        println("Corchetes balanceados: No, debe cerrar "+ (corchetesAbiertos - corchetesCerrados) +".")
      } else {
        println("Corchetes balanceados: No, debe abrir "+ (corchetesCerrados - corchetesAbiertos) +".")
      }
    }

  }

}

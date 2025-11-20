Parte 1

- Diferencia entre ci y cd

CI (Integración Continua)
Es el proceso que verifica automáticamente que cada cambio subido al repositorio funciona correctamente.
Incluye: compilar, correr pruebas, revisar estilo y medir cobertura.
 Objetivo: asegurar calidad del código y detectar errores rápido.

CD (Entrega/Despliegue Continuo)
Es el proceso que prepara o despliega automáticamente el software después de pasar CI.
Incluye: empaquetar, generar versiones y en algunos casos desplegar a producción.
 Objetivo: que el software llegue más rápido y sin esfuerzo a los usuarios.

 - Indicar lenguaje, linter y herramienta de cobertura a utilizar, con justificación

   
Para este proyecto decidí trabajar con Java porque es un lenguaje estable, fácil de integrar con Maven y muy práctico
para manejar todo el proceso de compilación y pruebas. Como linter usé Checkstyle, ya que me permite mantener un estilo 
de código limpio y, además, hace que el build falle si rompo alguna regla, lo cual ayuda a mantener buena calidad. Para la
cobertura utilicé JaCoCo, porque genera reportes claros y también permite exigir un porcentaje mínimo de cobertura para que
el proceso de CI falle si los tests no alcanzan ese nivel. Con estas tres herramientas puedo asegurar que el código se mantiene
ordenado, probado y con una cobertura adecuada dentro del workflow.

- Definir y justificar un umbral mínimo de cobertura (70–90%).

  Yo escogí un 80% de cobertura porque me parece un número razonable. No es tan bajito como 70% que dejaría muchas cosas sin probar,
   pero tampoco tan alto como 90% que ya se vuelve difícil de mantener. Con 80% siento que el código queda bien cubierto sin complicarse
   tanto, y así el CI puede avisar si falta hacer más pruebas sin volverlo tan estricto que moleste todo el tiempo.

  PARTE 3

  -Parte 3 – Uso de nektos/act:

  act sirve para correr los workflows de GitHub Actions en mi propio computador, sin subir nada al repositorio.

Qué hace:
Simula lo que haría GitHub cuando hago un push, para saber si el workflow funciona.

Requisitos:
Necesita Docker instalado, si no, no corre.

Cómo se usa:
En la carpeta del proyecto solo escribo: act push



PARTE 4 VALIDACION Y LOGS


 
-Cómo identificar fallos de linter, pruebas y cobertura en logs?

Cómo sé si falló el linter, las pruebas o la cobertura

Cuando corro el workflow o el comando mvn clean verify, me fijo en lo que aparece en la consola:

Si falla el linter que es el checkstyle:
En los logs aparece la palabra checkstyle y dice algo como violation o que rompí una regla de estilo.

Si fallan las pruebas:
Salen cosas como Failures o “Errors” en los tests. Si failures es mayor que 0, entonces un test salió mal.

Si falla la cobertura:
En los logs aparece algo de jacoco diciendo que no llegué al porcentaje mínimo de cobertura.

Cuando pasa cualquiera de estas cosas, al final siempre sale build failure.





- Generar un run fallido y uno exitoso y explicar la diferencia

  Run fallido: Para hacer uno fallido, cambié un test para que falle.
Cuando corrí el workflow, en los logs salió que había un error en los tests y al final decía BUILD FAILURE.
En GitHub Actions también salió en rojo.

Run exitoso: Cuando arreglé el test y volví a correr todo, esta vez salió todo en verde y al final decía BUILD SUCCESS.
Eso significa que pasó el linter, las pruebas y la cobertura sin problemas.



PARTE 5 IA Y ETICA 

-Métodos para detectar código generado por IA

Herramientas que revisan el estilo del código:
Hay páginas y programas que analizan cómo está escrito el código y comparan ese estilo con patrones comunes de IA. Si el código se ve demasiado “perfecto” o muy uniforme, lo marcan como sospechoso.

Comparar con otros códigos conocidos:
Algunos detectores comparan el código con bases de datos donde guardan ejemplos generados por IA. Si encuentran partes muy parecidas, dicen que puede haber sido hecho por una IA.


- Por qué no se puede asegurar al 100% la autoria.

No se puede saber con total seguridad porque:
Un humano puede escribir código parecido al de la IA.
Una IA también puede escribir código que parezca hecho por una persona.
Si alguien edita el código generado por IA, ya no se puede distinguir.
Los detectores pueden equivocarse y dar falsos positivos o falsos negativos.
Por eso ningún detector puede garantizar un 100% de certeza.


Políticas razonables para usar IA en educación y calidad

Permitir usar IA como apoyo, pero no para entregar todo sin entenderlo.
Obligar a citar cuando se usó IA, igual que cuando se usa un libro o una página web.
Pedir que el estudiante explique su propio código, para asegurarse de que entiende lo que entregó.
Usar la IA para aprender o mejorar, no solo para copiar.
Evaluar más el razonamiento del estudiante, no solo el resultado final.


 

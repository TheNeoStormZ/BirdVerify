# BirdVerify
BirdVerify es una aplicación de verificación de usuarios de Twitter que te permite buscar si un usuario específico estaba previamente. Esta aplicación utiliza una base de datos SQLite que contiene una lista de usuarios verificados en Twitter hasta el 11 de diciembre de 2022.

## Cómo utilizar la aplicación
Ingresa el nombre de usuario que deseas buscar en el campo de texto.
Haz clic en el botón de buscar.
- Si el usuario estaba verificado, se mostrará un mensaje indicando que el usuario está verificado.
- Si el usuario no estaba verificado, se mostrará un mensaje indicando que el usuario no está en la lista de verificados.
- Si el campo de texto está vacío, se mostrará un mensaje pidiendo que se ingrese un nombre de usuario válido.
## Cómo funciona la aplicación
La aplicación tiene dos elementos principales de interfaz de usuario: un campo de texto para ingresar el nombre de usuario y un botón para buscar. Cuando el usuario hace clic en el botón de búsqueda, se recupera el texto del campo de texto y se comprueba si el nombre de usuario es válido y no está vacío.

- Si el nombre de usuario es válido, se realiza una búsqueda en la base de datos SQLite para verificar si el usuario ha sido verificado previamente. Si el usuario ha sido verificado previamente, se muestra un mensaje en la pantalla indicando que el usuario está verificado. De lo contrario, se muestra un mensaje indicando que el usuario no está en la lista de verificados.

- Si el nombre de usuario no es válido, se muestra un mensaje pidiendo que se ingrese un nombre de usuario válido.

## Requisitos
La aplicación requiere que se tenga instalado un dispositivo con Android 10 (Q) o superior.
La versión objetivo es Android 13 (Tiramisu).


## Contribuyendo
Si deseas contribuir con el desarrollo de BirdVerify, puedes hacer un fork del repositorio y enviar un pull request. También puedes informar de problemas o sugerencias a través de la sección de "Issues" en GitHub.

## Menciones especiales
- La base de datos ha sido construida gracias al repositorio https://github.com/thansen0/verified_twitters, el cual contiene una copia en csv de los usuarios verificados hasta el 11/12/2022.
- El logo actual de la aplicación ha sido construido haciendo uso de Bing Image Creator.

## Análisis de VirusTotal
https://www.virustotal.com/gui/file/49aec2677d98bb6319ebf075ea6fdec4deec3822b3d88b6a93c7617e462d5944

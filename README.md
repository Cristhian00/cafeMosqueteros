# PROYECTO  FINAL CAFE MOSQUETERO
El proposito de esta implementación es mostrar la forma en como trabajan las empresas multinivel
enfocada en la venta de productos a base de café.


Los framework utilizados en este proyecto son las últimas versiones que hay hasta la fecha , En cuanto a al sistema operativo se recomienda utilizar win 10, y 
en cuanto explorador se recomienda chrome.



**Framework IntelliJ IDEA (Ultimate)** https://www.jetbrains.com/es-es/idea/download/#section=windows
Luego de descargar el .exe se ejecuta y nos sale la siguiente ventana.

![1](https://user-images.githubusercontent.com/64999632/162824582-1a216b7b-d826-4761-bb3d-9e05c7c17c7e.PNG)

![2](https://user-images.githubusercontent.com/64999632/162824587-bea30c6e-7cc1-47df-ae36-d37742aae456.PNG)

![3](https://user-images.githubusercontent.com/64999632/162824590-9bb0f3b5-f117-4ebb-83bd-627305172e68.PNG)

![4](https://user-images.githubusercontent.com/64999632/162824591-d60ee59d-95be-492e-8f6f-e96dce0ea678.PNG)

![5](https://user-images.githubusercontent.com/64999632/162824594-ecdf8700-76c3-4e0a-b266-c6f87c62d7ad.PNG)


Mientras se instala el entorno , se debe hacer un registro para la licencia de educador que otorga IntelliJ IDEA. Los pasos para el registro son los siguientes:

Ingresamos al siguiente link: [JetBrains Account](https://account.jetbrains.com/login) y nos registramos con la cuenta institucional.


![6](https://user-images.githubusercontent.com/64999632/162824932-9aed7aae-e1c5-40b5-bf3c-9a1187d61d3c.PNG)

Después del registro se le otorgará una licencia por 1 año.

_**Instalación de JDK**_ 


Antes de la instalación del JDK debes  tener en cuenta ORACLE, si no la tiene en el siguiente link podrá registrase: [Conexión a Oracle: inicio de sesión único](https://login.oracle.com/mysso/signon.jsp)

Para la descarga del JDK se ingresa al siguiente enlace: [Java Downloads | Oracle](https://www.oracle.com/java/technologies/downloads/) y descargar la versión 11 de java

![8](https://user-images.githubusercontent.com/64999632/162825404-a23288d2-ea0b-43c2-b612-2762d35b0ac7.PNG)

Luego de completar la descarga ejecutamos el .exe

![9](https://user-images.githubusercontent.com/64999632/162825443-1a4d3c18-a91a-4cf2-b2ad-712a2e3d07c9.PNG)

![10](https://user-images.githubusercontent.com/64999632/162825444-d664011a-71e1-462a-9d7c-2cf7a11fb3d6.PNG)

![11](https://user-images.githubusercontent.com/64999632/162825446-cfe1f350-8048-4bc1-9c84-adf3587340f6.PNG)


**_Instalación de motor de bases de datos_**

Instale el motor de base de datos MySQL versión Community Edition Versión 8
( https://dev.mysql.com/downloads/mysql/ ).
En caso de que ya esté instalado omita este paso

![20](https://user-images.githubusercontent.com/64999632/162825657-e06e2260-3b4b-4f7d-a536-ca3cff1d89fe.PNG)

![21](https://user-images.githubusercontent.com/64999632/162825663-92956fce-df0b-45e6-83e8-51e67e7fcc37.PNG)

Al finalizar la instalación ejecutamos el instalador.

para la configuración del mysql se puede direccionar a esta blog :[▷ Cómo instalar MySQL en Windows 10 paso a paso (profesionalreview.com)](https://www.profesionalreview.com/2018/12/13/mysql-windows-10/) 

**_NOTA IMPORTANTE:_** No puedes olvidar el password que creó para acceder a la base.

**NOTA:** luego de instalar el MySQL  se debe crear la base de datos en el Command line client llamada “cafeMosqueteros” con el siguiente código:

![30](https://user-images.githubusercontent.com/64999632/162825988-d6441a62-38a9-441b-a427-aa4f2a722ef9.PNG)

Para comprobar que la base de datos fue creada correctamente, lo puedes hacer con el siguiente comando:

![31](https://user-images.githubusercontent.com/64999632/162826092-6f5b129d-51e6-49a6-9b3c-70b5edcdd87d.PNG)

Por último utilizaremos el comando “use” para seleccionar la base de datos que anteriormente creamos.

![33](https://user-images.githubusercontent.com/64999632/162826217-b4895344-d3c4-4029-9331-2b9e3e84d049.PNG)

Luego de tener todo instalado y la bases de datos creada y en uso se debe abrir el proyecto incialmente ejecutar el archivo PersistenciaApplication dentro de la carpeta persistencia para la creacion de las tablas y 
la información suministrada, luego ejecuta el archivo WepApplication que esta en la carpeta web , por ultimo se dirige al navegador y introduce localhost:8080 . 


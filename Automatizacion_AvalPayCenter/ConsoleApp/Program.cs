using System;
using System.Diagnostics;
using System.IO;
using System.IO.Compression;

namespace ConsoleApp
{
    public class Program
    {
        string rutaProyecto; //DECLARANDO VARIABLE DE LA RUTA DEL PROYECTO
        public static string RutaEvidencia, rutaComprimido; //DECLARANDO LAS VARIABLES PUBLIC STATIC PARA QUE PUEDAN SER LLAMADAS DESDE CUALQUIER METODO
        string resultConsole;// DECLARANDO VARIABLE QUE CONTIENE TODO EL MSJ DE CONSOLA
        string estadoCaso;// DECLARANDO VARIABLE QUE CONTIENE EL ESTADO DEL CASO
        bool estado;// DECLARANDO LA VARIABLE QUE CONTIENE EL ESTADO DEL CASO EN TIPO BOOLEANO

        public static void Main(String[] args)
        {
        }

        //ESTE METODO SE ENCARGA DE EXTRAER UN SEGMENTO DEL TEXTO DEL RESULTADO DE LA EJECUCION POR CONSOLA
        public void extraerResultado(string palabraInicio, string texto)
        {
            string fraseCompleta = "";//INICIALIZANDO LA VARIABLE QUE GUARDA LA FRASE COMPLETA
            int indexPrimera = texto.IndexOf(palabraInicio);
            fraseCompleta = texto.Substring(indexPrimera);
            int startIndex = 17; //SE SELECCIONA LA POSICION INICIAL DEL TEXTO EXTRAIDO
            int length = 7;  //SE SELECCIONA EL TAMAÑO EN CARACTERES DE LA PALABRA QUE SE DESEA CAPTURAR
            estadoCaso = fraseCompleta.Substring(startIndex, length);
        }

        //ESTE METODO SE ENCARGA DE EXTRAER EL SEGMENTO DEL RESULTADO DE LA EJECUCION POR CONSOLA
        public void ExtraerRutaCarpeta(string palabraInicio, string texto)
        {
            string fraseCompleta = "";//INICIALIZANDO LA VARIABLE QUE GUARDA LA FRASE COMPLETA
            int indexPrimera = texto.IndexOf(palabraInicio);
            fraseCompleta = texto.Substring(indexPrimera);
            int startIndex = 20; //SE SELECCIONA LA POSICION INICIAL DEL TEXTO EXTRAIDO
            int length = 11;  //SE SELECCIONA EL TAMAÑO EN CARACTERES DE LA PALABRA QUE SE DESEA CAPTURAR
            RutaEvidencia = rutaProyecto + fraseCompleta.Substring(startIndex, length);
            //rutaComprimido = Comprimir(RutaEvidencia);

        }

        //ESTE METODO SE ENCARGA DE EJECUTAR EL COMANDO MVN EN LA RAIZ DEL PROGRAMA EN JAVA
        public bool OpenWithStartInfo(string Test, string rutas)
        {
            try
            {
                rutaProyecto = @rutas;
                //NOS UBICAMOS EN LA RUTA DONDE SE ENCUENTRA EL PROYECTO JAVA Y SE LANZA COMANDO DE EJECUCION POR CONSOLA
                Process process = new Process();
                ProcessStartInfo startInfo = ObtenerInformacionProceso(rutaProyecto);
                startInfo.WindowStyle = ProcessWindowStyle.Maximized;
                process.StartInfo = startInfo;
                process.StartInfo.CreateNoWindow = true;
                process.StartInfo.RedirectStandardInput = true;
                process.StartInfo.RedirectStandardOutput = true;
                process.StartInfo.UseShellExecute = false;
                process.Start();
                process.StandardInput.WriteLine(Test);
                process.StandardInput.Flush();
                process.StandardInput.Close();
                process.WaitForExit();

                resultConsole = process.StandardOutput.ReadToEnd();
                extraerResultado("Estado del caso:", resultConsole);//SE LLAMA EL METODO DE EXTRACCION DEL REDULTADO DE EJECUCION, ENVIANDO EL STRING DESDE DONDE SE QUIERE INCIAR ESTA EXTRACCION
                ExtraerRutaCarpeta("Ruta de la carpeta:", resultConsole);//SE LLAMA EL METODO DE EXTRACCION DEL RUTA DONDE SE ENCUENTRA LA EVIDENCIA, ENVIANDO EL STRING DESDE DONDE SE QUIERE INCIAR ESTA EXTRACCION
                if (estadoCaso.Contains("Exitoso"))// CONDICIONAL PARA ASIGNAR EL ESTADO DEL CASO
                {
                    estado = true;//SE ASIGNA EL ESTADO DEL CASO A LA VARIABLE ESTADO DE TIPO BOOLEANO
                    rutaComprimido = Comprimir(RutaEvidencia, "Exitoso");//SE ESTABLECE LA RUTA Y NOMBRE DEL ARCHIVO PARA LAS EVIDENCIAS
                }
                else
                {
                    estado = false;//SE ASIGNA EL ESTADO DEL CASO A LA VARIABLE ESTADO DE TIPO BOOLEANO
                    rutaComprimido = Comprimir(RutaEvidencia, "Fallido");//SE ESTABLECE LA RUTA Y NOMBRE DEL ARCHIVO PARA LAS EVIDENCIAS
                }
            }
            catch (Exception i)
            {
                //EN CASO DE NO HABER UN MENSAJE EN CONSOLA QUE NOS DE EL ESTADO DEL CASO, SE EMITE COMO FALLIDO
                Console.WriteLine("IMPRIMIR EL ESTADO " + estado); //SE IMPRIME POR CONSOLA EL ESTADO DEL CASO
                Console.Write(i);//SE ESCRIBE POR CONSOLA LA EXCEPCION
                estado = false;////SE ASIGNA EL ESTADO DEL CASO A LA VARIABLE ESTADO DE TIPO BOOLEANO
            }

            return estado;//SE RETORNA EL ESTADO DEL CASO DE PRUEBA
        }


        //METODO PARA INICIAR LA CONSOLA
        public ProcessStartInfo ObtenerInformacionProceso(string directorioTrabajo)
        {
            ProcessStartInfo startInfo = new ProcessStartInfo
            {
                WorkingDirectory = directorioTrabajo,
                FileName = "cmd.exe"
            };
            return startInfo;
        }

        //INICIALIZA EL PROCESO DE EJECUCION
        public static bool Ejecutar(string Test, string rutas)
        {
            Program myProcess = new Program();
            bool estadoEjecucion = myProcess.OpenWithStartInfo(Test, rutas);
            return estadoEjecucion;
        }

        //METODO ENCARGADO DE ENVIAR LA RUTA DE LAS EVIDENCIAS EL 
        public static string ruta()
        {
            return rutaComprimido;
        }

        public string Comprimir(string ruta, string estadoCasoFinal)
        {
            string startPath = @ruta;//RUTA DE LA CARPETA DONDE ESTAN LAS EVIDENCIAS
            string rutaC = ruta + estadoCasoFinal + ".zip";//RUTA DONDE SE VA A GUARDAR EL ARCHIVO .ZIP CON LAS EVIDENCIAS
            string zipPath = @rutaC;//RUTA DEL .ZIP
            File.Delete(zipPath);// ELIMINA LA CARPETA .ZIP EN CASO DE QUE EXISTA
            System.Threading.Thread.Sleep(2000);//TIEMPO DE ESPERA 
            ZipFile.CreateFromDirectory(startPath, zipPath);//CREAMOS LA CARPETA .ZIP DONDE SE ENCUENTRAN LAS EVIDENCIAS
            return zipPath; //RETORNA LA RUTA DEL .ZIP CREADO
        }

    }
}

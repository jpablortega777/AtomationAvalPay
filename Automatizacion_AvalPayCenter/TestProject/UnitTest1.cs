using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApp;
using System;

namespace TestProject
{
    [TestClass]
    public class UnitTest1
    {
        private TestContext testContextInstance;
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }
        [TestInitialize()]
        public void TestInitialize()
        {
            this.TestContext.Properties["__Tfs_TestCaseId__"].ToString();

        }
        
        [TestMethod]
        public void Ejecucion()
        {
            string ruta = @"D:\Automatizacion_AvalPayCenter\ConsoleApp\ATH";
            var CasoID = TestContext.Properties["__Tfs_TestCaseId__"].ToString(); //SE EXTRAE EL ID DEL CASO DE PRUEBA
            var sprint = "RunPrincipal";
            //var CasoID = 675450;    
            bool estado = Program.Ejecutar("mvn test -Dtest=" + sprint + "#CasoDePrueba" + CasoID, ruta);// COMANDO MVN PARA EJECUTAR EL TEST DESDE LA CONSOLA
            string rutaEvidencia = Program.ruta();// SE EXTRAE LA RUTA DEL ARCHIVO .ZIP DONDE SE ENCUENTRAN LAS EVIDENCIAS
            TestContext.AddResultFile(@rutaEvidencia);// SE AGREGAN LAS EVIDENCIAS AL RESULTADO DE LA PRUEBA
            Assert.AreEqual(true, estado);// SE VALIDA MEDIANTE EL ASSERT SI LA PRUEBA FUE FALLIDA O EXITOSA
        }
    }
}

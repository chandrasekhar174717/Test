using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTestProject1
{
    public class SimpleTest
    {

        private String param = "";

        public SimpleTest(String param)
        {
            this.param = this.param;
        }

        private SimpleTest CreateSimpleTestobj(string name)
        {
            SimpleTest objST = new SimpleTest(name);
            return objST;
        }
        public void beforeClass()
        {
            Console.WriteLine("Before class executed");
        }

        [TestMethod]
        public void testMethod()
        {
            List<string> values = new List<string>();
            List<string> paramvalues = new List<string>();
            values.Add("(Apple");
            values.Add("Banana");
            values.Add("Oramge");
            foreach (var v in values)
            {
                var obj = CreateSimpleTestobj(v);
                Console.WriteLine(("Value is:" + this.param));
                paramvalues.Add(this.param);
               
            }
            Assert.AreEqual("Apple", paramvalues[0]);
            Assert.AreEqual("Apple", paramvalues[1]);
            Assert.AreEqual("Apple", paramvalues[2]);

        }
    }
}

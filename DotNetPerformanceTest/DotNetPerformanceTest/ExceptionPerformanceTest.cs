using System;
using System.Diagnostics;

namespace DotNetPerformanceTest
{
    class ExceptionPerformanceTest
    {
        public void Test()
        {
            var stopwatch = Stopwatch.StartNew();
            ExceptionTest(1_000_000);
            stopwatch.Stop();
            Console.WriteLine(1_000_000);
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        private long ExceptionTest(long times)
        {
            long counter = 0;
            for (int i = 0; i < times; i++)
            {
                try
                {
                    Throw();
                }
                catch (Exception ex)
                {
                    if (ex.Message != "message")
                    {
                        throw new Exception("test failed");
                    }
                    counter++;
                }
            }
            return counter;
        }


        private void Throw()
        {
            throw new Exception("message");
        }
    }
}

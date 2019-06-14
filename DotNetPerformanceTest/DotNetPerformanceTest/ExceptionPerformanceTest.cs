using System;
using System.Diagnostics;

namespace DotNetPerformanceTest
{
    class ExceptionPerformanceTest
    {
        public void Test()
        {
            var stopwatch = Stopwatch.StartNew();
            ExceptionTest(100_000);
            stopwatch.Stop();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        private void ExceptionTest(long times)
        {
            for (int i = 0; i < times; i++)
            {
                try
                {
                    throw new Exception();
                }
                catch (Exception ex)
                {
                    //Ignore
                }
            }
        }
    }
}

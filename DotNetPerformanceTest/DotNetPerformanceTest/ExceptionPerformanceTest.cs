using System;
using System.Diagnostics;

namespace DotNetPerformanceTest
{
    class ExceptionPerformanceTest
    {
        public void Test()
        {
            var stopwatch = Stopwatch.StartNew();
            ExceptionTest(1000_000);
            stopwatch.Stop();
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
                    counter++;
                }
            }
            return counter;
        }


        private void Throw()
        {
            throw new Exception();
        }
    }
}

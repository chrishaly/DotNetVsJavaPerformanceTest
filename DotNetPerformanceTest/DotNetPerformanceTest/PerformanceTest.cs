using System;
using System.Diagnostics;

namespace DotNetPerformanceTest
{
    class PerformanceTest
    {
        public void Test()
        {
            Measure(() => ExceptionTest(100_000), "ExceptionTest(100_000)");
            Measure(() => ParseIntTest(1_000_000), "ParseIntTest(1_000_000)");
            Measure(() => LongSumTest(100_000_000), "LongSumTest(100_000_000)");
        }

        public void Measure(Action action, string name)
        {
            var sw = Stopwatch.StartNew();
            action();
            sw.Stop();
            Console.WriteLine($"{name}\t{sw.ElapsedMilliseconds}");
        }

        private void ExceptionTest(long times)
        {
            for (int i = 0; i < times; i++)
            {
                try
                {
                    throw new Exception();
                }
                catch (Exception)
                {
                    //Ignore
                }
            }
        }

        private void ParseIntTest(long times)
        {
            for (int i = 0; i < times; i++)
            {
                int.Parse("1");
            }
        }

        private long LongSumTest(long times)
        {
            long result = 0;
            for (long i = 0; i < times; i++)
            {
                result += i;
            }
            //Console.WriteLine(result);
            return result;
        }

    }
}

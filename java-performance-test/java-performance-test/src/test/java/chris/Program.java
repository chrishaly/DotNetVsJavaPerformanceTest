package chris;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.junit.Test;

public class Program {

    @Test
    public void test1() {
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        String dbName = "mydb";

        System.out.println("hello");
    }
}

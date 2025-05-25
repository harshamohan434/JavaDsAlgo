package DesignPatterns;

public class TemplatePattern {
    public static void main(String[] args) {
        DataExporter csvExporter = new CsvExporter();
        TxtExporter txtExporter = new TxtExporter();

        csvExporter.extract();
        txtExporter.extract();
    }
}

class CsvExporter extends DataExporter{
    @Override
    void format() {
        System.out.println("export csv file");
    }
}

class TxtExporter extends DataExporter{
    @Override
    void format() {
        System.out.println("export txt file");
    }
}

abstract class DataExporter{
    public void extract(){
        read();
        format();
        write();
    }
    void read(){
        System.out.println("Read File");
    }
    void format(){}
    void write(){
        System.out.println("Write to file");
    }
}

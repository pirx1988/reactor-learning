package rp.assignment.FileService2;

import rp.courseutil.Util;

public class Main {
    public static void main(String[] args) {
        FileService2 fileService = new FileService2("input.csv");
        fileService.read().subscribe(Util.subscriber());

        FileService2 fileService2 = new FileService2("Hadoop_2k.log");
        fileService2.read().subscribe(Util.subscriber());
//
        FileService2 fileService3 = new FileService2("Apache_2k.log");
        fileService3.read().subscribe(Util.subscriber());
    }
}

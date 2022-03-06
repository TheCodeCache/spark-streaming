package com.stream.test.sparksqs;

import javax.management.JMException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class NativeMemory {

    public static String execute(String command, String... args) throws JMException {
        return (String) ManagementFactory.getPlatformMBeanServer().invoke(
                new ObjectName("com.sun.management:type=DiagnosticCommand"),
                command,
                new Object[]{args},
                new String[]{"[Ljava.lang.String;"});
    }

    public static void main(String[] args) throws Exception {
        String summary = NativeMemory.execute("vmNativeMemory", "summary");
        System.out.println(summary);
    }
}

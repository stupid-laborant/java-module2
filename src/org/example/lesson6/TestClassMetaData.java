package org.example.lesson6;

public class TestClassMetaData {
    public int id;
    @GetMetaData
    private String code;
    private String[] properties;
    public boolean isValid;

    public TestClassMetaData(int id, String code, String[] properties, boolean isValid) {
        this.id = id;
        this.code = code;
        this.properties = properties;
        this.isValid = isValid;
    }

    public void methodWithoutAnnotation() {
        System.out.println("This is method without annotation");
    }

    @GetMetaData
    public void annotatedMethod() throws InterruptedException {
        System.out.println("Method with annotation started");
        Thread.sleep(100);
        System.out.println("Method with annotation finished");
    }
}

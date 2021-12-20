package be.technifutur.laboJava.serialization;

public class TestSerialization {

    public static void main(String[] args) {
        DataStore<MyData> myDataDataStore = new DataStore<>("test.ser", MyData::new);

        MyData dt= myDataDataStore.getData();

        dt.list.add("element "+dt.list.size());

        myDataDataStore.save();

        for (String s : dt.list){
            System.out.println(s);
        }

    }
}

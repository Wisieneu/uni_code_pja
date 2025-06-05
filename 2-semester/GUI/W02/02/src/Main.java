public class Main {
    public static void main ( String [] args )
    {
        Singer s1 = new Singer (" Eminem "){
            sing()->{return }
        };
        Singer s2 = new Singer (" Eagles "){
            /* <- kod */
        };
        Singer s3 = new Singer ("Dżem"){
            /* <- kod */
        };
        Singer sp [] = {s1 , s2 , s3 };
        for ( Singer s : sp)
            System.out.println(s);
        System.out.println("\n" + Singer.loudest(sp));
    }
}
public class Message {

    public final Utilisateur sender;
    public final long timeOfSending; // format YYYYMMDDhhmmss : 20240601232542
    public final String content;
    private static long[] ID = new long[1];

    public static long[] append(long[] list, long x)
    {
        long[] new_arr = new long[list.length + 1];
        for (int i = 0; i < list.length; i++) 
        {         
            new_arr[i] = list[i];
        }
        new_arr[list.length] = x;
        return (new_arr);
    }

    public Message(Utilisateur s , long t, String c)
    {
        this.sender = s;
        this.timeOfSending = t;
        this.content = c;        
        long id = t + c.length(); // algo pas hyper efficace de generation de "unique" IDs
        ID = append(ID, id);
    }

    public void Send_display() {
        System.out.println("\nUser " + this.sender.getPseudonyme() + " Sent a message :  " + this.content + "\nat "
        + this.timeOfSending); 
    }

}

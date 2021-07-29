public class MyBitOperations {

    public int setBit(int number, int ith){
        return (number | (1 << ith));
    }

    public int getBit(int number, int ith){
        int x = (number & (1 << ith));

        if(x != 0) return 1;

        return 0;
    }

    public int clearBit(int number, int ith){
        return (number & (~(1 << ith)));
    }

}

package data.tree;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

       /* BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        System.out.println(bst);*/
    }

    @Test
    public void testBufferdInputStream() throws IOException
    {

        InputStream in = new FileInputStream("D://test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        int i=bufferedInputStream.read();


    }

}

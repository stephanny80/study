package com.example.api.utils;

import java.util.Arrays;

public class DescobrirLacunaArrayInt {
/*

		int[] A = new int[5];
		A[0] = 2;
		A[1] = 8;
		A[2] = 4;
		A[3] = 3;
		A[4] = 2;
		System.out.println(descobrirLacunaArrayInt(A));

 */
    public static int descobrirLacunaArrayInt(int[] A) {
        // Implement your solution here
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("error");
        }

        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        int tam = A.length;
        int resultado = A[0];
        for (int count = 0; count < tam; count++) {
//            System.out.println(resultado);
//            System.out.println(A[count]);
//            System.out.println("");
            if (A[count] > resultado && A[count] != resultado + 1 && A[count] > 0) {
                return resultado + 1;
            } else {
                resultado = A[count];
            }
        }
        System.out.println("Resultado = " + resultado);
        if (resultado <= 0) resultado = 1;
        return (resultado++);
    }

}

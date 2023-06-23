package com.example.api.utils;

public class FormatCpf {
			/*

				String cpf = "12345678900";
			String formattedCPF = formatCPF(cpf);
			System.out.println("Formatted CPF: " + formattedCPF);

			int [] A = new int[4];
			A[0] = 1;
			A[1] = 2;
			A[2] = 3;
			A[3] = 6;

			System.out.println(solution(A));
			*/

    public String formatCPF(String cpf) {
        // Remove any non-digit characters from the input string
        cpf = cpf.replaceAll("\\D", "");

        // Insert formatting characters
        StringBuilder formattedCPF = new StringBuilder(cpf);
        formattedCPF.insert(3, '.');
        formattedCPF.insert(7, '.');
        formattedCPF.insert(11, '-');

        return formattedCPF.toString();
    }

}

package com.example.api.utils;

public class GasStation {
    /*
    int[] A = new int[5];
    A[0] = 2;
    A[1] = 8;
    A[2] = 4;
    A[3] = 3;
    A[4] = 2;

    GasStation gasStation = new GasStation();
		System.out.println(gasStation.fuel(A, 7, 11, 3));
*/

    public int fuel(int[] A, int bombX, int bombY, int bombZ) {

        if (!verifyCarAndBomb(A, bombX, bombY, bombZ)) return -1;

        int cars = A.length;
        int totalCarsFuel = 0;
        int waiting = 0;
        int[] tankOfCars = new int[A.length];

        while (allCarsFuel(A, bombX, bombY, bombZ)) {
            for (int car = 0; car < A.length; car++) {
                if (A[car] == 0) {
                    tankOfCars[car] = 0;
                }
            }
            for (int car = 0; car < A.length; car++) {
                if (bombIdle(1, car, A, tankOfCars) && bombX >= A[car] && A[car] > 0) {
                    tankOfCars[car] = 1; //primeira bomba
                    A[car]--;
                    bombX--;
                } else {
                    if (bombIdle(2, car, A, tankOfCars) && bombY >= A[car] && A[car] > 0) {
                        tankOfCars[car] = 2; //segunda bomba
                        A[car]--;
                        bombY--;
                    } else {
                        if (bombIdle(3, car, A, tankOfCars) && bombZ >= A[car] && A[car] > 0) {
                            tankOfCars[car] = 3; //terceira bomba
                            A[car]--;
                            bombZ--;
                        } else {
                            if (A[car] > 0) {
                                waiting ++;
                            }
                        }
                    }
                }
            }
        }
        if (allCarsFuelComplete(A)) return waiting;
        return -1;
    }

    private boolean allCarsFuel(int[] A, int bombX, int bombY, int bombZ) {
        boolean carNeedsFuel = false;
        boolean bombEmpty = false;
        //cars fuel
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) carNeedsFuel = true;
        }

        //bombs Empty
        if (bombX + bombY + bombZ > 0) {
            bombEmpty = true;
        }

        return carNeedsFuel && bombEmpty;

    }

    private boolean bombIdle(int bombNumber, int car, int[] A, int[] tankOfCars) {
        //bomb no fuel
        //if (A[bombNumber] == 0) return false;

        //bomb car
        if (tankOfCars[car] == bombNumber) return true;

        //bomb free
        boolean bombFree = true;
        for (int i = 0; i < tankOfCars.length; i++) {
            if (bombFree && i != car && tankOfCars[i] == bombNumber) bombFree = false;
        }

        return bombFree;
    }

    private boolean allCarsFuelComplete(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total = total + A[i];
        }
        return total == 0;
    }

    private boolean verifyCarAndBomb (int[] A, int bombX, int bombY, int bombZ) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > bombX && A[i] > bombY && A[i] > bombZ )
                return false;
        }
        return true;
    }

}

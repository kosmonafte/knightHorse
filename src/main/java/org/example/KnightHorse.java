package org.example;

import java.security.KeyManagementException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class KnightHorse {
    public static int[][] goHorse(int[][] field, int i, int j, int step) throws InterruptedException {
        step++;
        field[i][j] = step;
        int[] move = KnightHorse.moveVariants(field, i, j);
        System.out.println(KnightHorse.showField(field));
        System.out.println("---------------------------------");
        Thread.sleep(1000);
        //System.out.println(Arrays.toString(move));
        //{9,3,9,5,9,9,0,9};
        int min = 10;
        int index = 10;
        for (int k = 0; k < move.length; k++) {
            if (move[k] != 9 && move[k] < min) {
                min = move[k];
                index = k;
            }
        }

        int[][] res = new int[8][8];
        if (index == 10) {
            res = field;
        } else {
            if (index == 0) {
                res = goHorse(field, i-2,j+1, step);
            } else if (index == 1) {
                res = goHorse(field,i-1,j+2, step);
            } else if (index == 2) {
                res = goHorse(field,i+1,j+2, step);
            } else if (index == 3) {
                res = goHorse(field,i+2,j+1, step);
            } else if (index == 4) {
                res = goHorse(field,i+2,j-1, step);
            } else if (index == 5) {
                res = goHorse(field,i+1,j-2, step);
            } else if (index == 6) {
                res = goHorse(field,i-1,j-2, step);
            } else if (index == 7) {
                res = goHorse(field,i-2,j-1, step);
            }
        }
        return res;
    }

    public static String showField(int[][] field) {
        String str = new String();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                str += String.format("%2d  ", field[i][j]);//String.valueOf(field[i][j]) + "  ";
            }
            str += "\n";
        }
        return str;
    }

    public static int[] moveVariants(int[][] field, int i, int j) {
        int[] variants = new int[]{9,9,9,9,9,9,9,9};
        if (i == 0) {
            if (j == 0) {
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
            } else if (j == 1) {
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
            } else if (j == field.length - 1) {
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
            } else if (j == field.length - 2) {
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
            } else {
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
            }
        } else if (i == 1) {
            if (j == 0) {
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
            } else if (j == 1) {
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
            } else if (j == field.length - 1) {
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
            } else if (j == field.length - 2) {
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
            } else {
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
            }
        } else if (i == field.length - 1) {
            if (j == 0) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
            } else if (j == 1) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else if (j == field.length - 1) {
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else if (j == field.length - 2) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
            }
        } else if (i == field.length - 2) {
            if (j == 0) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
            } else if (j == 1) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else if (j == field.length - 1) {
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else if (j == field.length - 2) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            }
        } else {
            if (j == 0) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
            } else if (j == 1) {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else if (j == field.length - 1) {
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            } else if (j == field.length - 2) {
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
            } else {
                if (field[i-2][j+1] == 0) {
                    variants[0] = moves(field, i-2, j+1);
                }
                if (field[i-1][j+2] == 0) {
                    variants[1] = moves(field, i-1, j+2);
                }
                if (field[i+1][j+2] == 0) {
                    variants[2] = moves(field, i+1, j+2);
                }
                if (field[i+2][j+1] == 0) {
                    variants[3] = moves(field, i+2, j+1);
                }
                if (field[i+2][j-1] == 0) {
                    variants[4] = moves(field, i+2, j-1);
                }
                if (field[i+1][j-2] == 0) {
                    variants[5] = moves(field, i+1, j-2);
                }
                if (field[i-1][j-2] == 0) {
                    variants[6] = moves(field, i-1, j-2);
                }
                if (field[i-2][j-1] == 0) {
                    variants[7] = moves(field, i-2, j-1);
                }
            }
        }
        return variants;
    }

    public static int moves(int[][] field, int i, int j) {
        int steps = 0;
        if (i == 0) {
            if (j == 0) {
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
            } else if (j == 1) {
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 1) {
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
            } else if (j == field.length - 2) {
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
            } else {
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
            }
        } else if (i == 1) {
            if (j == 0) {
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
            } else if (j == 1) {
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 1) {
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
            } else if (j == field.length - 2) {
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
            } else {
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
            }
        } else if (i == field.length - 1) {
            if (j == 0) {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
            } else if (j == 1) {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 1) {
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 2) {
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
            } else {
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
            }
        } else if (i == field.length - 2) {
            if (j == 0) {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
            } else if (j == 1) {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 1) {
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 2) {
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
            } else {
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
            }
        } else {
            if (j == 0) {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
            } else if (j == 1) {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 1) {
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            } else if (j == field.length - 2) {
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
            } else {
                if (field[i-2][j+1] == 0) {
                    steps++;
                }
                if (field[i-1][j+2] == 0) {
                    steps++;
                }
                if (field[i+1][j+2] == 0) {
                    steps++;
                }
                if (field[i+2][j+1] == 0) {
                    steps++;
                }
                if (field[i+2][j-1] == 0) {
                    steps++;
                }
                if (field[i+1][j-2] == 0) {
                    steps++;
                }
                if (field[i-1][j-2] == 0) {
                    steps++;
                }
                if (field[i-2][j-1] == 0) {
                    steps++;
                }
            }
        }
        return steps;
    }
}

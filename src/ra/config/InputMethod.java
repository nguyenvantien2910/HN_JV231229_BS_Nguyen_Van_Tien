package ra.config;

import java.util.Scanner;

public class InputMethod {
        private static final String ERROR_ALERT = "Định dạng không hợp lệ, hoặc ngoài phạm vi! Vui lòng nhập lại!";
            private static final String EMPTY_ALERT = "Trường nhập vào không thể để trống! Vui lòng nhập lại!";

            //get input method
            private static String getInput() {
                Scanner input = new Scanner(System.in);
                return input.nextLine();
            }

            //get String method
            public static String getString() {
                while (true) {
                    String result = getInput();
                    if (result.isEmpty()) {
                        System.err.println(EMPTY_ALERT);
                        continue;
                    }
                    return result;
                }
            }

            //get byte method
            public static byte getByte() {
                while (true) {
                    try {
                        return Byte.parseByte(getString());
                    } catch (NumberFormatException errException) {
                        System.err.println(ERROR_ALERT);
                    }
                }
            }

            //get byte double
            public static double getDouble() {
                while (true) {
                    try {
                        return Double.parseDouble(getString());
                    } catch (NumberFormatException errException) {
                        System.err.println(ERROR_ALERT);
                    }
                }
            }

            //get interger method
            public static int getInteger() {
                while (true) {
                    try {
                        return Integer.parseInt(getString());
                    } catch (NumberFormatException errException) {
                        System.err.println(ERROR_ALERT);
                    }
                }
            }

            //get float
            public static float getFloat() {
                while (true) {
                    try {
                        return Float.parseFloat(getString());
                    } catch (NumberFormatException errException) {
                        System.err.println(ERROR_ALERT);
                    }
                }
            }

            //get boolean method
            public static boolean getBoolean() {
                String result = getString();
                return result.equalsIgnoreCase("true");
            }
}

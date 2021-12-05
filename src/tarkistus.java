public class tarkistus {

    public class Main {
        /**
         * CRC calculation
         *
         * @param data    The byte to crc check
         * @param crcInit The current crc result or another start value
         * @param poly    The polynom
         * @return The crc result
         */
        public static byte crc8(byte data, byte crcInit, byte poly) {

            byte crc;
            byte polynom;
            int i;

            crc = crcInit;
            for (i = 0; i < 8; i++) {

                if ((uint(crc) & 0x80) != 0) {
                    polynom = poly;
                } else {
                    polynom = (byte) 0;
                }

                crc = (byte) ((uint(crc) & ~0x80) << 1);
                if ((uint(data) & 0x80) != 0) {
                    crc = (byte) (uint(crc) | 1);
                }

                crc = (byte) (uint(crc) ^ uint(polynom));
                data = (byte) (uint(data) << 1);
            }
            return crc;
        }

        /**
         * Convert to unsigned int
         *
         * @param v
         * @return
         */
        public static int uint(byte v) {
            return v & 0xFF;
        }
    }
}
public class S34380 {
    public class Rakieta {
        String nazwa;
        int wagaPaliwa;

        public Rakieta(String nazwa, int wagaPaliwa) {
            this.nazwa = nazwa;
            this.wagaPaliwa = wagaPaliwa;
        }

        public void zatankuj() {
            this.wagaPaliwa = (int) Math.random() * 2000;

        }

        public void start() throws Exception {
            if (this.wagaPaliwa < 1000) {
                throw new Exception("start anulowany - za malo paliwa");
            }
        }
    }
}

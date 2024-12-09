public class S34380 {
    public class Prostokat {
        protected double bokPodstawy1;
        protected double bokPodstawy2;
        protected double polePodstawy;

        public Prostokat(double bokPodstawy1, double bokPodstawy2) {
            this.bokPodstawy1 = bokPodstawy1;
            this.bokPodstawy2 = bokPodstawy2;
            this.polePodstawy = bokPodstawy1 * bokPodstawy2;
        }

        public void show() {
            System.out.println("Pole prostokata: " + this.polePodstawy);
        }
    }

    public class Prostopadloscian extends Prostokat {
        private double wysokoscBryly;
        private double polePowierzchni;
        private double objetosc;

        public Prostopadloscian(double bokPodstawy1, double bokPodstawy2, double wysokoscBryly) {
            super(bokPodstawy1, bokPodstawy2);
            this.wysokoscBryly = wysokoscBryly;
        
            this.objetosc = super.polePodstawy * wysokoscBryly;
            this.polePowierzchni = 2 * (super.bokPodstawy1 * this.wysokoscBryly) + (2 * (super.bokPodstawy2 * wysokoscBryly)) + (2 * super.polePodstawy);
        }

        public void show(){
            System.out.println("Objetosc bryly: " + this.objetosc);
            System.out.println("Pole powierzchni: " + this.polePowierzchni);
        }
    }

    public class Trojkat {
        private double bokPodstawy;
        private double wysokoscPodstawy;
        private double poleFigury;

        public Trojkat(double bokPodstawy, double wysokoscPodstawy) {
            this.bokPodstawy = bokPodstawy;
            this.wysokoscPodstawy = wysokoscPodstawy;
            this.poleFigury = 0.5 * bokPodstawy * this.wysokoscPodstawy; // dla uproszczenia zakladam ze to trojkat rownoboczny
        }

        public void show() {
            System.out.println("Pole trojkata: " + this.poleFigury);
        }
    }

    class Ostroslup extends Trojkat {
        private double wysokoscBryly;
        private double wysokoscSciany;
        private double objetosc;
        private double polePowierzchni;
    
        public Ostroslup(double bokPodstawy, double wysokoscPodstawy, double wysokoscBryly, double wysokoscSciany) {
                super(bokPodstawy, wysokoscPodstawy);
                this.wysokoscBryly = wysokoscBryly;
                this.wysokoscSciany = wysokoscSciany;

                this.objetosc = super.poleFigury * this.wysokoscBryly / 3;
                this.polePowierzchni = super.poleFigury + ((super.bokPodstawy * this.wysokoscSciany) * 3);
            }    
        
        public void show() {
            System.out.println("Objetosc ostroslupa: " + this.objetosc);
            System.out.println("Pole powierzchni ostroslupa: " + this.polePowierzchni);
        }
    }

    class Graniastoslup extends Trojkat {
        private double wysokoscBryly;
        private double objetosc;
        private double polePowierzchni;

        public Graniastoslup(double bokPodstawy, double wysokoscPodstawy, double wysokoscBryly) {
            super(bokPodstawy, wysokoscPodstawy);
            this.wysokoscBryly = wysokoscBryly;
            
            this.objetosc = super.poleFigury * wysokoscBryly;
            this.polePowierzchni = (super.poleFigury * 2) + (3 * (super.bokPodstawy * this.wysokoscBryly));
        }

        public void show() {
            System.out.println("Objetosc: " + this.objetosc);
            System.out.println("Pole powierzchni: " + this.polePowierzchni);
        }
    }
}

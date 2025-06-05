public class S34380 {
    public class Prostokat {
        protected double bokFigury1;
        protected double bokFigury2;
        protected double polePodstawy;

        public Prostokat(double bokFigury1, double bokFigury2) {
            this.bokFigury1 = bokFigury1;
            this.bokFigury2 = bokFigury2;
            this.polePodstawy = bokFigury1 * bokFigury2;
        }

        public void show() {
            System.out.println("Pole prostokata: " + this.polePodstawy);
        }
    }

    public class Prostopadloscian extends Prostokat {
        private double wysokoscBryly;
        private double polePowierzchni;
        private double objetosc;

        public Prostopadloscian(double bokFigury1, double bokFigury2, double wysokoscBryly) {
            super(bokFigury1, bokFigury2);
            this.wysokoscBryly = wysokoscBryly;
        
            this.objetosc = super.polePodstawy * wysokoscBryly;
            this.polePowierzchni = 2 * (super.bokFigury1 * this.wysokoscBryly) + (2 * (super.bokFigury2 * wysokoscBryly)) + (2 * super.polePodstawy);
        }

        public void show(){
            System.out.println("Objetosc bryly: " + this.objetosc);
            System.out.println("Pole powierzchni: " + this.polePowierzchni);
        }
    }

    public class Trojkat {
        private double bokFigury;
        private double poleFigury;

        public Trojkat(double bokFigury, double wysokoscPodstawy) {
            this.bokFigury = bokFigury;
            this.poleFigury = bokFigury * bokFigury * Math.sqrt(3) / 4; // dla uproszczenia zakladam ze to trojkat rownoboczny
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
    
        public Ostroslup(double bokFigury, double wysokoscPodstawy, double wysokoscBryly, double wysokoscSciany) {
                super(bokFigury, wysokoscPodstawy);
                this.wysokoscBryly = wysokoscBryly;
                this.wysokoscSciany = wysokoscSciany;

                this.objetosc = super.poleFigury * this.wysokoscBryly / 3;
                this.polePowierzchni = super.poleFigury + ((super.bokFigury * this.wysokoscSciany) * 3);
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

        public Graniastoslup(double bokFigury, double wysokoscPodstawy, double wysokoscBryly) {
            super(bokFigury, wysokoscPodstawy);
            this.wysokoscBryly = wysokoscBryly;
            
            this.objetosc = super.poleFigury * wysokoscBryly;
            this.polePowierzchni = (super.poleFigury * 2) + (3 * (super.bokFigury * this.wysokoscBryly));
        }

        public void show() {
            System.out.println("Objetosc: " + this.objetosc);
            System.out.println("Pole powierzchni: " + this.polePowierzchni);
        }
    }
}

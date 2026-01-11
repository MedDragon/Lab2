package sample;

public enum CustomerType {
    COMPANY {
        @Override
        public double getOverdraftDiscount(boolean isPremium, double companyDiscount) {
            return isPremium ? (companyDiscount / 2) : companyDiscount;
        }
    },
    PERSON {
        @Override
        public double getOverdraftDiscount(boolean isPremium, double companyDiscount) {
            return 1.0;
        }
    };

    public abstract double getOverdraftDiscount(boolean isPremium, double companyDiscount);
}
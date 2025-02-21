package _35_library;

public class Loan {
    private static int progressive = 0; // just for show
    private int number;
    private int ISBN;
    private int memberId;

    public Loan(Book book, Member member) {
        this.ISBN = book.getISBNNumber();
        this.memberId = member.getId();
        this.number = progressive++;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

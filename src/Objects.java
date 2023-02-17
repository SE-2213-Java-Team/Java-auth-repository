public abstract class Objects<N> {
    private N IIN;
    private String Login;
    private String Password;
    public N getIIN(){return IIN;}
    public void setIIN(N IIN){this.IIN = IIN;}
    public String getLogin(){return Login;}
    public void setLogin(String Login){this.Login = Login;}
    public String getPassword(){return Password;}
    public void setPassword(String Password){this.Password = Password;}
    protected boolean checkUser(String input, String IIN, String login){return true;}
}

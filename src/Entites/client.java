package Entites;

public class client {
    private Integer id_client;
    private String nom;
    private String prenom;
    private String ville;
    private String tel;
    private String mail;
    private String password;

    public client(String nom, String prenom, String ville, String tel, String mail, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.password = password;
    }

    public client(String nom, String prenom, String ville, String tel, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
    }

    public client(Integer id_client, String nom, String prenom, String ville, String tel, String mail,
            String password) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.password = password;
    }

    public client() {
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId_client() {
        return id_client;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getVille() {
        return ville;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

}

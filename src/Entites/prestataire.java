package Entites;

public class prestataire {

    private Integer id_Prestataire;
    private String nom;
    private String prenom;
    private String ville;
    private String tel;
    private String mail;
    private String password;
    private String experience;
    private String nomService;
    private String typeService;

    public prestataire() {
    }

    public prestataire(Integer id_Prestataire, String nom, String prenom, String ville, String tel, String experience,
            String nomService, String typeService) {
        this.id_Prestataire = id_Prestataire;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.tel = tel;
        this.experience = experience;
        this.nomService = nomService;
        this.typeService = typeService;
    }

    public prestataire(Integer id_Prestataire, String nom, String prenom, String ville, String tel, String mail,
            String password, String experience, String nomService, String typeService) {
        this.id_Prestataire = id_Prestataire;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.password = password;
        this.experience = experience;
        this.nomService = nomService;
        this.typeService = typeService;
    }

    public void setId_Prestataire(Integer id_Prestataire) {
        this.id_Prestataire = id_Prestataire;
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

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public Integer getId_Prestataire() {
        return id_Prestataire;
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

    public String getExperience() {
        return experience;
    }

    public String getNomService() {
        return nomService;
    }

    public String getTypeService() {
        return typeService;
    }

}

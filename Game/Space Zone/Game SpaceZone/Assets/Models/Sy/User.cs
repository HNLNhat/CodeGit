public class User
{
    public User(string email, string password)
    {
        this.email = email;
        this.password = password;
    }
    public User(string email, string password, string name, int age)
    {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }
    public User(string id, int score, string scene, string positionx, string positiony, string positionz)
    {
        this.id = id;
        this.score = score;
        this.scene = scene;
        this.positionx = positionx;
        this.positiony = positiony;
        this.positionz = positionz;
    }

    public string id { get; set; }
    public string email { get; set; }
    public string password { get; set; }
    public string name { get; set; }
    public int age { get; set; }
    public int score { get; set; }
    public string scene { get; set; }
    public string positionx { get; set; }
    public string positiony { get; set; }
    public string positionz { get; set; }
}

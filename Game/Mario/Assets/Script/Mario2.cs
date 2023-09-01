using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;//Doi man

public class Mario2 : MonoBehaviour
{
    private float speed;
    public Rigidbody2D rigidbody2D;
    private bool isRight;

    //animator
    private Animator animator;
    public float isRunning;
    public bool isJump;

    // nhạc
    private AudioSource audioSource;
    private AudioClip coins;

    // điểm
    private int coin;
    public Text coinText;

    //đếm thời gian chơi
    private int time; //Thời gian tính băng giây
    public Text timeText; //Hiển thị thời gian chơi
    private bool isAlive; //Kiểm tra nhân vật tương tác

    //Viên đạn
    public GameObject fireBall;

    //Menu
    public bool isActive;
    public GameObject menu;
    public Text menuTimeText;

    //Life
    private int life;
    public Text lifeText;
    private Vector2 originalPosition;
    

    // Start is called before the first frame update
    void Start()
    {
        // tốc độ
        speed = 5f;
        rigidbody2D = GetComponent<Rigidbody2D>();
        isRight = true;

        animator = GetComponent<Animator>();
        isRunning = 0;
        isJump = false;

        audioSource = GetComponent<AudioSource>();
        coins = GetComponent<AudioClip>();

        coin = 0;

        PlaySound("Sounds/Cowboy Theme");

        isAlive = true;
        time = 0;
        timeText.text = time + "s";
        StartCoroutine(UpdateTime());

        isActive = false;
        life = 3;
        lifeText.text = life + "";
    }
    // Cập nhật thời gian 1 giây chạy 1 lần
    IEnumerator UpdateTime()
    {
        while (isAlive)
        {
            time++;
            timeText.text = time + "s";
            yield return new WaitForSeconds(1);
        }
    }

    // Update is called once per frame
    void Update()
    {
        animator.SetFloat("IsRunning", isRunning);
        animator.SetBool("IsJump", isJump);
        //isRunning= 0;

        //Bắn đạn
        if (Input.GetKeyDown(KeyCode.S))
        {
            //Tạo đạn 
            GameObject fire = Instantiate(fireBall);
            fire.transform.position = new Vector3(
                transform.position.x + (isRight ? 0.7f : -0.7f),
                transform.position.y,
                transform.position.z);

            fire.GetComponent<FireBall>().SetSpeed(isRight ? 10 : -10);
        }

        if (Input.GetKey(KeyCode.D))
        {

            // xoay mặt qua phải
            if (isRight == false)
            {
                Vector2 scale = transform.localScale;
                scale.x *= scale.x < 0 ? -1 : 1;
                transform.localScale = scale;
                isRight = true;
            }

            // vận tốc
            //rigidbody2D.velocity = new Vector2(speed,0);
            //isRunning = speed;
            transform.Translate(Vector3.right * speed * Time.deltaTime);
            isRunning = 100;
        }

        else if (Input.GetKey(KeyCode.A))
        {
            // xoay mặt qua trái
            if (isRight == true)
            {
                Vector2 scale = transform.localScale;
                scale.x *= scale.x > 0 ? -1 : 1;
                transform.localScale = scale;
                isRight = false;
            }
            // vận tốc
            //rigidbody2D.velocity = new Vector2(-speed,0);
            //isRunning = speed;
            transform.Translate(Vector3.left * speed * Time.deltaTime);
            isRunning = 100;
        }
        else if (Input.GetKeyDown(KeyCode.Space))
        {
            rigidbody2D.AddForce(new Vector2(0, 300));
            isJump = true;
            isRunning = 0;
            PlaySound("Sounds/Dead");

        }
        else
        {
            isRunning = 0;
        }
        //isRunning = Mathf.Abs(rigidbody2D.velocity.x);

        if (Input.GetKeyDown(KeyCode.P))
        {
            if (!isActive)
            {
                isActive = true;
                menu.SetActive(true);
                Time.timeScale = 0;
               // menuTimeText.text = "Your score " + time;
            }
            else
            {
                isActive = false;
                menu.SetActive(false);
                Time.timeScale = 1;

                originalPosition = transform.localPosition;
            }
        }
    }
    //Bắt sựu kiện 2 box collider va chạm nhau
    private void OnCollisionEnter2D(Collision2D collision)
    {
        var name = collision.gameObject.tag;
        if (name.Equals("SanGach"))
        {
            isJump = false;
        }
        // if (collision.gameObject.CompareTag("SanGach"))
        // {
        //   isJump = false;
        // }
        else if (collision.gameObject.CompareTag("Rua"))
        {
            // Debug.Log("Cham vao nam>>>");
            //Kiểm tra chạm trên , dưới, phải, trái

            /*direction.x == 1: Cham ben phai
            direction.x == -1: Cham ben trai
            direction.y == -1: Cham ben duoi
            direction.y == 1: Cham ben tren*/

            Vector2 direction = collision.GetContact(0).normal;

            float directionX = direction.x;
            float directionY = direction.y;

            if (directionX > 0)
            {
                //mario chết
                //Destroy(gameObject);
                 LifeRespawn();

            }
            else if (directionX < 0)
            {
                //mario chết
                // Destroy(gameObject);
                LifeRespawn();

            }
            else if (directionY > 0)
            {
                //Giết quái
                // Destroy(collision.gameObject);
            }
            else
            {
                //mario chết
                // Destroy(gameObject);
                LifeRespawn();
            }
            // Debug.Log("X: " + direction.x);
            //Debug.Log("Y: " + direction.y);
            
        } 
    }
    //Bắt sự kiện va chạm is Trigger
    private void OnTriggerEnter2D(Collider2D collision)
    {
        var name = collision.gameObject.tag;
        if (name.Equals("Coin"))
         if (collision.gameObject.CompareTag("Coin"))
        {
            //Phát nhạc
            PlaySound("Sounds/coin sound");

            //Biến mất
            Destroy(collision.gameObject);
            //Tăng điểm
            coin++;
            coinText.text = coin + " X ";
        }
    }
    private void PlaySound(string name)
    {
        audioSource.PlayOneShot(Resources.Load<AudioClip>(name));
    }
    public void QuitGame()
    {
        Application.Quit(); //Chi chay trong product
    }
    public void ResumeGame()
    {
        isActive = false;
        menu.SetActive(false);
        Time.timeScale = 1;
    }
    public void NextScene()
    {
        SceneManager.LoadScene(1);
    }
    private void LifeRespawn()
    {
        if (life >= 1)
        {
            life--;
            lifeText.text = life + "";
            SceneManager.LoadScene(0);
            transform.localPosition = originalPosition;
        }
        else
        {
            //Game over
            Debug.Log("Game over");
        }
    }
    }


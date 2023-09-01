using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Boss : MonoBehaviour
{
    public float left, right;
    public float speed;
    public bool isRight;

    public GameObject bossFireBall;
    private float timeSpawn; //thoi gian tao vien dan
    private float time; //Thoi gian dem

    // nhạc


    // Start is called before the first frame update
    void Start()
    {
        timeSpawn = 1;
        time = timeSpawn;
    }

    // Update is called once per frame
    void Update()
    {

        float positionX = transform.localPosition.x;
        if (positionX < left)
        {
            //Quay qua phai
            isRight = true;
        }
        else if (positionX > right)
        {
            //Quay qua trai
            isRight = false;
        }
        Vector3 vector3;
        if (isRight)
        {
            Vector2 scale = transform.localScale;
            scale.x *= scale.x > 0 ? -1 : 1;
            transform.localScale = scale;

            vector3 = new Vector3(1, 0, 0);
        }
        else
        {
            Vector2 scale = transform.localScale;
            scale.x *= scale.x > 0 ? 1 : -1;
            transform.localScale = scale;

            vector3 = new Vector3(-1, 0, 0);
        }
        transform.Translate(vector3 * speed * Time.deltaTime);
        time -= Time.deltaTime;
        if (time <= 0)
        {
            time = timeSpawn;
            GameObject fb = Instantiate(bossFireBall);
            fb.transform.position = new Vector2(
                transform.position.x + (isRight ? 0.8f : -0.8f),
                transform.position.y
                );
            fb.GetComponent<BossFireBall>().SetSpeed(
                isRight ? 10 : -10
                );
        }

    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
        Vector2 direction = collision.GetContact(0).normal;
        if (Mathf.Round(direction.x) == 1 || Mathf.Round(direction.x) == -1)
        {
            if (collision.gameObject.tag == "Player")
            {
                Destroy(gameObject);
             //   PlaySound("Sounds/kill");
            }

        }

    }
}

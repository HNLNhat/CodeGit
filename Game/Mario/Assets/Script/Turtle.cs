using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Turtle : MonoBehaviour
{
    public float left, right;
    public float speed;
    public bool isRight;

    public Sprite newSprite; //Hình mới 
    private bool isAlive; //Kiểm tra sống chết
    public float speedUp; //Vận tốc đi lên
    public float height; //Độ cao
    private Vector2 originalPosition; //Vị trí ban đầu

    // Start is called before the first frame update
    void Start()
    {
        isAlive = true;
    }

    // Update is called once per frame
    void Update()
    {
        if (!isAlive) return; //Nếu đã chết thì đứng yên

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

        int random = Random.Range(1, 10);
        if(random % 2 == 0)
        {
            //Nhay
            GetComponent<Rigidbody2D>()
                .AddForce(Vector2.up * 10);
        }
        if(random % 3 == 0)
        {
            //Choi bua
            //instance

        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Player"))
        {
            var direction = collision.GetContact(0).normal;
            //Bị đạp
            if (Mathf.Round(direction.y) == -1)
            {
                //Đổi hình
                GetComponent<SpriteRenderer>().sprite = newSprite;
                //Tắt animation
                GetComponent<Animator>().enabled = false;
                //Tắt chuyển động
                isAlive = false;
                //Nãy lên //Rớt xuống
                originalPosition = transform.position;
                GetComponent<BoxCollider2D>().isTrigger = true;
                StartCoroutine(GoUp());
                //Biến mất
                Destroy(gameObject, 2);
            }
        }
    }
    IEnumerator GoUp()
    {
        //khối đi lên
        while (true)
        {
            transform.position = new Vector2(
               transform.position.x,
               transform.position.y + speedUp * Time.deltaTime);
            if (transform.position.y > originalPosition.y + height) break;
            yield return null;
        }
    }
}
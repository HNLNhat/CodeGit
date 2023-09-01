using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Monter2_Movement : MonoBehaviour
{
    [SerializeField] private Transform point1;
    [SerializeField] private Transform point2;
    private float moveSpeedMonter2 = 4f;
    private bool isLeft = true;
    private bool isAttack = false;
    private Transform player;
    private Rigidbody2D rb2d;
    private SpriteRenderer spr;
    private Vector3 previousPosition;
    private Vector3 currentPosition;
    // Start is called before the first frame update
    void Start()
    {
        rb2d = GetComponent<Rigidbody2D>();
        spr = GetComponent<SpriteRenderer>();

        previousPosition = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        if (!isAttack)
            move();
        else
        {
            Invoke("getPreviousPosition", 1);
            currentPosition = transform.position;
            Vector3 target = new Vector3(player.position.x, transform.position.y, transform.position.z);
            transform.position = Vector3.MoveTowards(transform.position, target, moveSpeedMonter2 * Time.deltaTime);
            if ((currentPosition.x - previousPosition.x) < 0)
            {
                spr.flipX = true;
            }
            else if ((currentPosition.x - previousPosition.x) > 0)
            {
                spr.flipX = false;
            }
        }

    }

    private void move()
    {

        if (transform.position.x <= point1.position.x)
        {
            isLeft = false;

        }
        if (transform.position.x >= point2.position.x)
        {
            isLeft = true;

        }

        if (isLeft)
        {
            transform.Translate(Vector3.left * Time.deltaTime * moveSpeedMonter2);
            spr.flipX = true;
        }
        else
        {
            transform.Translate(Vector3.right * Time.deltaTime * moveSpeedMonter2);
            spr.flipX = false;
        }
    }

    private void OnTriggerEnter2D(Collider2D collider2D)
    {

        if (collider2D.CompareTag("Player"))
        {
            isAttack = true;
            player = collider2D.transform;
        }
    }
    private void OnTriggerExit2D(Collider2D collider2D)
    {

        if (collider2D.CompareTag("Player"))
        {
            isAttack = false;
        }
    }
    private void getPreviousPosition()
    {
        previousPosition = transform.position;
    }
}

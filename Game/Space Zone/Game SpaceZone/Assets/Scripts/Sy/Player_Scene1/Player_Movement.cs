using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Movement : MonoBehaviour
{
    [SerializeField] private float moveSpeed = 10f;
    [SerializeField] private float jumpForce = 14f;
    private float dirX = 0f;
    private enum MoveType { idle, running, jumping, falling };
    private MoveType state = MoveType.idle;

    private Rigidbody2D rb2d;
    private SpriteRenderer spr;
    private Animator animator;
    // Start is called before the first frame update
    void Start()
    {
        rb2d = GetComponent<Rigidbody2D>();
        spr = GetComponent<SpriteRenderer>();
        animator = GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        move();
    }

    private void move()
    {
        dirX = Input.GetAxisRaw("Horizontal");
        rb2d.velocity = new Vector2(dirX * moveSpeed, rb2d.velocity.y);

        if (Input.GetButtonDown("Jump"))
        {
            rb2d.AddForce(new Vector2(rb2d.velocity.x, jumpForce));
        }

        if (dirX > 0f)
        {
            spr.flipX = false;
            state = MoveType.running;
        }
        else if (dirX < 0f)
        {
            spr.flipX = true;
            state = MoveType.running;
        }
        else
        {
            state = MoveType.idle;
        }

        if (rb2d.velocity.y > .1f)
        {
            state = MoveType.jumping;
        }
        else if (rb2d.velocity.y < -.1f)
        {
            state = MoveType.falling;
        }

        animator.SetInteger("state", (int)state);
    }

    void OnTriggerEnter2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("Explosion"))
        {
            moveSpeed += 10f;
            Invoke("downMoveSpeed", 3);
        }
    }

    private void downMoveSpeed()
    {
        moveSpeed -= 10f;
    }
}

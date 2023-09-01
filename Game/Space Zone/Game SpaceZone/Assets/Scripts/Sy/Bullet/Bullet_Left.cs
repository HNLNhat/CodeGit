using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet_Left : MonoBehaviour
{
    [SerializeField] private float bulletSpeed = 14f;
    private Rigidbody2D rb2d;
    private Animator animator;
    // Start is called before the first frame update
    void Start()
    {
        rb2d = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();

        Invoke("delete", 0.8f);
    }

    // Update is called once per frame
    void Update()
    {
        bulletMoveRight();
    }

    private void bulletMoveRight()
    {
        rb2d.velocity = new Vector2(-bulletSpeed, rb2d.velocity.y);
    }

    private void delete()
    {
        Destroy(gameObject);
    }

    void OnCollisionEnter2D(Collision2D collision2D)
    {
        if (collision2D.gameObject.CompareTag("Monter"))
        {
            animator.SetTrigger("run");
        }
    }
}

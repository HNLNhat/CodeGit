using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BossFireBall : MonoBehaviour
{
    private new Rigidbody2D rigidbody2D;
    public float speedUp;
    // Start is called before the first frame update
    void Start()
    {
        Rotation();
        rigidbody2D = GetComponent<Rigidbody2D>();
        rigidbody2D.velocity = new Vector2(speedUp, 0);
        Destroy(gameObject, 2);
    }

    // Update is called once per frame
    void Update()
    {

    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
    }
    public void SetSpeed(float value)
    {
        speedUp = value;
    }
    public void Rotation()
    {
        if(speedUp > 0)
        {
            Vector2 scale = transform.localScale;
            scale.x *= scale.x > 0 ? 1 : -1;
            transform.localScale = scale;
        }
        else
        {
            Vector2 scale = transform.localScale;
            scale.x *= scale.x > 0 ? -1 : 1;
            transform.localScale = scale;
        }
    }
}


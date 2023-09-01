using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Scene2_Attack : MonoBehaviour
{
    [SerializeField] GameObject bulletRight;
    [SerializeField] GameObject bulletLeft;
    private float time = 0f;
    private SpriteRenderer spr;
    // Start is called before the first frame update
    void Start()
    {
        spr = GetComponent<SpriteRenderer>();
    }

    // Update is called once per frame
    void Update()
    {
        attack();
    }

    private void attack()
    {
        time += Time.deltaTime;
        if (Input.GetButtonDown("Fire1"))
        {
            if (time >= 0.3f)
            {
                if (spr.flipX == false)
                {
                    Instantiate(bulletRight, transform.position, Quaternion.identity);
                    time = 0f;
                }
                else
                {
                    Instantiate(bulletLeft, transform.position, Quaternion.identity);
                    time = 0f;
                }
            }

        }
    }
}

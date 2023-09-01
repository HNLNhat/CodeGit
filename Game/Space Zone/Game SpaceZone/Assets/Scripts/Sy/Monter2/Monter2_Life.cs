using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Monter2_Life : MonoBehaviour
{
    [SerializeField] private int health = 4;
    [SerializeField] private GameObject healthObject;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    void OnCollisionEnter2D(Collision2D collision2D)
    {
        if (collision2D.gameObject.CompareTag("Bullet"))
        {
            health--;
            if (health <= 0)
            {
                ScoreManger.setMonter2Count();
                Destroy(gameObject);
            }
            else
            {
                healthObject.transform.localScale = new Vector3((float)health, 0.2f, 1f);
            }
        }
    }
}

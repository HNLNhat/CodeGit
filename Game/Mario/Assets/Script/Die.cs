using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Die : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
    
}
    private void OnCollisionEnter2D(Collision2D collision)
    {
        Vector2 direction = collision.GetContact(0).normal;
        if (Mathf.Round(direction.x) == 1 || Mathf.Round(direction.x) == -1)
        {
            if (collision.gameObject.tag == "Nam")
            {
                Destroy(gameObject);
                // PlaySound("Sounds/kill");
            }

        }

    }

}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Explosion_Life : MonoBehaviour
{
    private Animator animator;
    // Start is called before the first frame update
    void Start()
    {
        animator = GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {

    }

    public void delete()
    {
        Destroy(gameObject);
    }
    void OnTriggerEnter2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("Player"))
        {
            animator.SetTrigger("destroy");
        }
    }
}

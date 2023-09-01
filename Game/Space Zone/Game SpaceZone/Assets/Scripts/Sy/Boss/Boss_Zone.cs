using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Boss_Zone : MonoBehaviour
{
    [SerializeField] private GameObject boss;
    private Boss_Movement boss_Movement;
    // Start is called before the first frame update
    void Start()
    {
        boss_Movement = boss.GetComponent<Boss_Movement>();
    }

    // Update is called once per frame
    void Update()
    {

    }

    void OnTriggerEnter2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("Player"))
        {
            boss_Movement.SetBossMove(true);
            Debug.Log("enter player");
        }
    }
    void OnTriggerExit2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("Player"))
        {
            boss_Movement.SetBossMove(false);
            Debug.Log("exit player");
        }
    }
}

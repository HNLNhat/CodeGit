using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Boss_Movement : MonoBehaviour
{
    [SerializeField] private Transform player;
    [SerializeField] private Slider healthBossSlider;
    [SerializeField] private GameObject healthBossSuite;

    private enum MoveType { idle, running, attack, hurt };
    private MoveType state = MoveType.idle;

    private float moveSpeedBoss;
    private float moveSpeedBossAttack = 8f;
    private float moveSpeedBossWayBack = 5f;
    private int healthBossMax = 200;
    private int healthBossCurrent;

    private bool isBossMove = false;
    private bool isBossMoveDefault = false;
    private bool isAttack = false;
    private bool isHurt = false;
    private bool isBossDie = false;

    private Vector3 previousPosition;
    private Vector3 currentPosition;
    private Vector3 defaultPosition;

    private Rigidbody2D rb2d;
    private SpriteRenderer spr;
    private Animator animator;
    // Start is called before the first frame update
    void Start()
    {
        rb2d = GetComponent<Rigidbody2D>();
        spr = GetComponent<SpriteRenderer>();
        animator = GetComponent<Animator>();

        previousPosition = transform.position;
        defaultPosition = new Vector3(transform.position.x - .1f, transform.position.y, transform.position.z);

        healthBossCurrent = healthBossMax;
        healthBossSlider.maxValue = healthBossMax;
        healthBossSlider.value = healthBossCurrent;
    }

    // Update is called once per frame
    void Update()
    {
        if (!isBossDie)
        {
            directBoss();
            if (currentPosition.x != defaultPosition.x) isBossMoveDefault = true;

            if (isBossMove || isBossMoveDefault || isHurt)
            {
                if (isBossMove)
                {
                    moveSpeedBoss = moveSpeedBossAttack;
                    bossMove();
                    if (isAttack)
                    {
                        bossAttack();
                    }
                }
                else if (isBossMoveDefault)
                {
                    moveSpeedBoss = moveSpeedBossWayBack;
                    bossMoveDefault();
                }

                if (isHurt)
                {
                    state = MoveType.hurt;
                }
            }
            else
            {
                state = MoveType.idle;
            }

            animator.SetInteger("state", (int)state);

            healthBossSlider.value = healthBossCurrent;

            bossDie();
        }

    }

    public void SetBossMove(bool isMove)
    {
        isBossMove = isMove;
        if (!isMove)
        {
            isBossMoveDefault = true;
        }
        else
        {
            isBossMoveDefault = false;
        }
    }
    public int getHealthBossCurrent()
    {
        return healthBossCurrent;
    }

    private void bossMove()
    {
        // directBoss();

        Vector3 target = new Vector3(player.position.x, transform.position.y, transform.position.z);
        transform.position = Vector3.MoveTowards(transform.position, target, moveSpeedBoss * Time.deltaTime);

        state = MoveType.running;
    }
    private void bossMoveDefault()
    {
        // directBoss();

        Vector3 target = new Vector3(defaultPosition.x, transform.position.y, transform.position.z);
        transform.position = Vector3.MoveTowards(transform.position, target, moveSpeedBoss * Time.deltaTime);

        state = MoveType.running;

        if (currentPosition.x == defaultPosition.x) isBossMoveDefault = false;
    }
    private void bossAttack()
    {
        state = MoveType.attack;
    }
    private void bossDie()
    {
        if (healthBossCurrent <= 0)
        {
            isBossDie = true;
            healthBossSuite.SetActive(false);
            animator.SetTrigger("die");
        }
    }

    private void getPreviousPosition()
    {
        previousPosition = transform.position;
    }
    private void directBoss()
    {
        Invoke("getPreviousPosition", 0.02f);
        currentPosition = transform.position;
        if ((currentPosition.x - previousPosition.x) < 0)
        {
            spr.flipX = true;
        }
        else if ((currentPosition.x - previousPosition.x) > 0)
        {
            spr.flipX = false;
        }
    }

    void OnCollisionEnter2D(Collision2D collision2D)
    {
        if (collision2D.gameObject.CompareTag("Bullet"))
        {
            isHurt = true;
            moveSpeedBossAttack += 1f;
            healthBossCurrent -= 10;
        }
    }
    void OnCollisionExit2D(Collision2D collision2D)
    {
        if (collision2D.gameObject.CompareTag("Bullet"))
        {
            isHurt = false;
        }
    }
    private void OnTriggerEnter2D(Collider2D collider2D)
    {

        if (collider2D.CompareTag("Player"))
        {
            isAttack = true;
        }
    }
    private void OnTriggerExit2D(Collider2D collider2D)
    {

        if (collider2D.CompareTag("Player"))
        {
            isAttack = false;
        }
    }
}

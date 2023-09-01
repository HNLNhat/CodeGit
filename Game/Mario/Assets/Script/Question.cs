using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Question : MonoBehaviour
{
    private Vector2 originalPosition;
    public Sprite newBlock;
    public float speed, height;
    private bool canChange;
    public GameObject item1, item2, item3;

    // nhạc
    private AudioSource audioSource;
   
    void Start()
    {
        audioSource = GetComponent<AudioSource>();
        originalPosition = transform.position;
        canChange = true;
    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (!canChange) return;
        if (collision.gameObject.CompareTag("Player"))
        {
            canChange = false;
            //Chuyển thành 1 hình khác
            GetComponent<SpriteRenderer>().sprite = newBlock;
            //Tắt animation
            GetComponent<Animator>().enabled = false;
            //Nãy lên, rớt xuống
            StartCoroutine(GoUpAndDown());
          
            //Phát nhạc
           
                PlaySound("Sounds/smb3_coin");
            }
        }

    IEnumerator ItemGoUp(GameObject newItem)
    {
        while (true)
        {
            newItem.transform.position = new Vector2(
               newItem.transform.position.x,
               newItem.transform.position.y + speed * Time.deltaTime);
            if (newItem.transform.position.y > originalPosition.y + 0.5) break;
            yield return null;
        }
    }
    IEnumerator GoUpAndDown()
    {
    //khối đi lên
        while (true)
        {
            transform.position = new Vector2(
               transform.position.x,
               transform.position.y + speed * Time.deltaTime);
            if (transform.position.y > originalPosition.y + height) break;
            yield return null;
        }
        //Khối đi xuống
        while (true)
        {
            transform.position = new Vector2(
                transform.position.x,
                transform.position.y - speed * Time.deltaTime);
            if( transform.position.y < originalPosition.y)
            {
                transform.position = originalPosition;
                break;
            }
            yield return null;

        }
        //Tạo đồng xu, vật phẩm
        GameObject newItem;
        int random = Random.Range(0, 2);
        if (random == 1)
            newItem = Instantiate<GameObject>(item1);
        else if (random == 2)
            newItem = Instantiate<GameObject>(item2);
        else newItem = Instantiate<GameObject>(item3);
        newItem.transform.position = originalPosition;
        StartCoroutine(ItemGoUp(newItem));
    }

private void PlaySound(string name)
{
    audioSource.PlayOneShot(Resources.Load<AudioClip>(name));
}
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraFollow_Scene1 : MonoBehaviour
{
    [SerializeField] GameObject player;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        follow();
    }

    private void follow()
    {
        transform.position = new Vector3(player.transform.position.x, player.transform.position.y, -10);
    }
}

﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraScript : MonoBehaviour
{
    public GameObject player;
    public float start, end;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        //Lấy vị trí trục x của player
        var playerX = player.transform.position.x;

        //Lấy vị trí trục x cam
        var camX = transform.position.x;

        if(playerX > start && playerX < end)
        {
            camX = playerX;
        }
        else
        {
            if(playerX < start)
            {
                camX = start;
            }
            if(playerX > end)
            {
                camX = end;
            }
        }
        transform.position = new Vector3(camX, 0, -10);

    }
}
